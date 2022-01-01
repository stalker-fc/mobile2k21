from pathlib import Path

from aiohttp import web
from aiohttp_swagger import setup_swagger

from app.exceptions import NoSuchResourceException
from app.resources_service import ResourcesService
from app.resources_service import create_resources_service
from app.responses import ImageResponse, NotFoundResponse


async def index(request):
    return web.HTTPFound("/docs")


async def random_resource_id(request):
    """
       ---
       description: This end-point return random resource_id.
       tags:
       - Resources
       produces:
       - text/plain
       responses:
           "200":
               description: successful operation. returns `resource_id`
       """
    resources_service: ResourcesService = request.config_dict['resources_service']

    resource_id = resources_service.get_random_resource_id()
    return web.Response(
        status=200,
        body=str({
            "success": True,
            "resource_id": resource_id
        })
    )


async def resource(request):
    """
       ---
       description: This end-point returns image of resource with defined `id`.
       tags:
       - Resources
       produces:
       - image/png
       responses:
           "200":
               description: successful operation. Returns `.png`-image.
           "404":
               description: resource with such id is not exist.

       """
    resources_service: ResourcesService = request.config_dict['resources_service']
    resource_id = int(request.match_info['resource_id'])
    try:
        resource_data: bytes = resources_service.get_resource_data_by_id(resource_id)
        return ImageResponse(resource_data)
    except NoSuchResourceException as e:
        return NotFoundResponse(message=str(e))


def startup_app():
    app = web.Application()

    resources_dir = Path(__file__).parent.parent / "resources"
    resources_service = create_resources_service(resources_dir)
    app['resources_service'] = resources_service

    app.add_routes([
        web.get("/", index, allow_head=False),
        web.get("/random", random_resource_id, allow_head=False),
        web.get("/resource/{resource_id:[0-9]+}", resource, allow_head=False),
    ])

    setup_swagger(
        app,
        swagger_url="/docs",
    )
    return app
