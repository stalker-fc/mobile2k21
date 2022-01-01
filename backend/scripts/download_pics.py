import itertools
from pathlib import Path

import requests
from PIL import Image
from lxml import html


def load_sticker_pack(sticker_pack_url: str, save_dir: Path):
    page = requests.get(sticker_pack_url)
    tree = html.fromstring(page.content)
    base_url = tree.xpath("//meta[@property='og:image']/@content")[0].rsplit('/', 1)[0]

    save_dir.mkdir(parents=True, exist_ok=True)

    for i in itertools.count(1):
        img_url = "".join([base_url, f"/{i}.png"])
        r = requests.get(img_url, stream=True)
        if r.status_code == 200:
            with Image.open(r.raw) as img:
                save_path = save_dir / f"{i}.png"
                print(save_path)
                img.save(save_path)
        else:
            break


if __name__ == '__main__':
    sticker_pack_url = "https://tlgrm.ru/stickers/BrokenCats"
    sticker_pack_directory = Path(__file__).parent.parent / "resources"
    load_sticker_pack(sticker_pack_url, sticker_pack_directory)
