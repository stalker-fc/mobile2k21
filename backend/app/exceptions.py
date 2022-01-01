class NoSuchResourceException(Exception):
    def __init__(self, resource_id: int):
        self.resource_id = resource_id
        super().__init__(resource_id)

    def __str__(self):
        return f"There is no resource with such id = `{self.resource_id}`"

