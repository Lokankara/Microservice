from pydantic import BaseModel, ValidationError, Field, validator, field_validator
from basic_validator import BasicValidator
from typing import Optional, List, Union
import validators

basic_validator = BasicValidator()

class Category(BaseModel):
    id: int
    name: str

class CategoryId(BaseModel):
    id: int

class Tags(BaseModel):
    id: int
    name: str

class TagsId(BaseModel):
    id: int

class Pet(BaseModel):
    id: Optional[int]
    name: str
    status: str
    category: (Category | CategoryId) = None
    photoUrls: Optional[list[str]] = []
    tags: List[Union[Tags, TagsId]] = []

    @validator('tags', pre=True, each_item=True)
    def convert_tags_to_tags_id(cls, v):
        if isinstance(v, Tags):
            return TagsId(id=v.id)
        return v

    @validator('category', pre=True)
    def convert_category_to_category_id(cls, v):
        if isinstance(v, Category):
            return CategoryId(id=v.id)
        return v

    @validator('photoUrls')
    def check_photo_urls(cls, v):
        if not isinstance(v, list):
            raise ValueError("photoUrls must be a list")
        for url in v:
            if not (validators.url(url) or url.startswith("data:image")):
                raise ValueError(f"Invalid URL: {url}")
        return v
    
    @classmethod
    def check_photo_urls(cls, v: list[str]) -> list[str]:
        for url in v:
            if not (validators.url(url) or url.startswith("data:image")):
                # logging.error(f"Invalid url: {url}")
                raise ValueError("photoUrls must be a list of urls or empty")
        return v

    @classmethod
    def check_status(cls, v: str) -> str:
        if not basic_validator.is_valid_status(v):
            # logging.error(f"Invalid status: {v}")
            raise ValueError(f"Invalid status: {v}. Status must be 'available', 'pending', or 'sold'.")
        return v
        