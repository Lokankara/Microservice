import logging
from requests import Response
from pydantic import ValidationError
from .pets import Pets

class PetValidator:
    @staticmethod
    def validate_pet_response(response: Response):
        """
        This method validates that the response matches the expected schema.
        :param response: The response to validate.
        :return: True if the response matches the expected schema, otherwise returns error message.
        """
        data = response.text
        try:
            pets = Pets.model_validate_json(data)
            if pets.category is None:
                pets.model_dump(excuse_under=True)
                return True
            else:
                pets.model_dump()
                return True
        except ValidationError as e:
            # logging.error(f"Invalid data format {e.json()}")
            return e.json()
            