import random
from pathlib import Path
from typing import Dict

from app.exceptions import NoSuchResourceException


class ResourcesService:
    def __init__(self, resources_dir: Path):
        self._resources_dir = resources_dir
        self._resource_id_to_path: Dict[int, Path] = {
            resource_id: resource_path
            for resource_id, resource_path in enumerate(resources_dir.rglob("*.png"))
        }
        if len(self._resource_id_to_path) == 0:
            raise ValueError(f"There is no resources in resources_dir.")

    def get_resource_data_by_id(self, resource_id: int) -> bytes:
        try:
            resource_path = self._resource_id_to_path[resource_id]
            with open(str(resource_path), 'rb') as file:
                return file.read()
        except (KeyError, FileNotFoundError):
            raise NoSuchResourceException(resource_id)

    def get_random_resource_id(self) -> int:
        return random.randint(0, len(self._resource_id_to_path))


def create_resources_service(resources_dir: Path) -> ResourcesService:
    return ResourcesService(resources_dir)
