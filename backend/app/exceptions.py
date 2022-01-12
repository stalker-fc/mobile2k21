class NoSuchCatException(Exception):
    def __init__(self, cat_id: int):
        self.cat_id = cat_id
        super().__init__(cat_id)

    def __str__(self):
        return f"There is no cat with such id = `{self.cat_id}`"

