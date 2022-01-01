from aiohttp import web


class ImageResponse(web.Response):
    def __init__(self, image_data: bytes):
        super().__init__(
            body=image_data,
            status=200,
            content_type="content_type='image/png'",
            headers={
                'Access-Control-Allow-Origin': '*',
            }
        )


class NotFoundResponse(web.Response):
    def __init__(self, message: str):
        super().__init__(
            status=404,
            body=str({
                "success": False,
                "error": message
            })
        )


class InternalServerErrorResponse(web.Response):
    def __init__(self, traceback: str):
        super().__init__(
            status=500,
            body=str(
                {
                    "success": False,
                    "error": traceback
                }
            )
        )
