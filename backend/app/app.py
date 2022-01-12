from pathlib import Path

from aiohttp import web
from aiohttp_swagger import setup_swagger

from app.cats_service import CatsService
from app.cats_service import create_cats_service
from app.exceptions import NoSuchCatException
from app.responses import ImageResponse
from app.responses import NotFoundResponse


async def index(request):
    return web.HTTPFound("/docs")


async def random_cat_id(request):
    """
       ---
       description: This end-point return random cat_id.
       tags:
       - cats
       produces:
       - text/plain
       responses:
           "200":
               description: successful operation. returns `cat_id`
       """
    cats_service: CatsService = request.config_dict['cats_service']

    cat_id = cats_service.get_random_cat_id()
    return web.Response(
        status=200,
        body=str({
            "catId": cat_id
        })
    )


async def cat(request):
    """
       ---
       description: This end-point returns image of cat with defined `id`.
       tags:
       - cats
       produces:
       - image/png
       responses:
           "200":
               description: successful operation. Returns `.png`-image.
           "404":
               description: cat with such id is not exist.

       """
    cats_service: CatsService = request.config_dict['cats_service']
    cat_id = int(request.match_info['catId'])
    try:
        cat_data: bytes = cats_service.get_cat_data_by_id(cat_id)
        return ImageResponse(cat_data)
    except NoSuchCatException as e:
        return NotFoundResponse(message=str(e))


def startup_app():
    app = web.Application()

    cats_dir = Path(__file__).parent.parent / "cats"
    cats_service = create_cats_service(cats_dir)
    app['cats_service'] = cats_service

    app.add_routes([
        web.get("/", index, allow_head=False),
        web.get("/random_cat", random_cat_id, allow_head=False),
        web.get("/cat/{catId:[0-9]+}.jpg", cat, allow_head=False),
    ])

    setup_swagger(
        app,
        swagger_url="/docs",
    )
    return app
