import unittest
from pet_model import Pet

class TestPetModel(unittest.TestCase):
    def setUp(self):
        self.pet_data = {
            "id": 1,
            "category": {
                "id": 1,
                "name": "Max"
            },
            "name": "doggie",
            "photoUrls": ["string"],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        }

    def test_valid_photoUrls(self):
        pet_data = {
            "id": 1,
            "name": "Max",
            "status": "available",
            "photoUrls": ["https://example.com/image1.jpg", "https://example.com/image2.jpg"],
            "category": {"id": 1, "name": "Category1"},
            "tags": [{"id": 1, "name": "Tag1"}]
        }
        pet = Pet(**pet_data)
        self.assertTrue(isinstance(pet, Pet))
        self.assertEqual(pet.photoUrls, pet_data["photoUrls"])

    def test_pet_model(self):
        try:
            pet = Pet(**self.pet_data)
        except ValidationError as e:
            self.fail(f"Test failed due to validation error: {e}")

        self.assertEqual(pet.id, self.pet_data["id"])
        self.assertEqual(pet.name, self.pet_data["name"])
        self.assertEqual(pet.status, self.pet_data["status"])
        self.assertEqual(pet.category.id, self.pet_data["category"]["id"])
        self.assertEqual(pet.category.name, self.pet_data["category"]["name"])
        self.assertEqual(pet.photoUrls, self.pet_data["photoUrls"])
        self.assertEqual(pet.tags[0].id, self.pet_data["tags"][0]["id"])
        self.assertEqual(pet.tags[0].name, self.pet_data["tags"][0]["name"])

    # def test_invalid_pet_model(self):
    #     invalid_pet_data = self.pet_data.copy()
    #     invalid_pet_data["status"] = "invalid_status"

    #     with self.assertRaises(ValidationError):
    #         pet = Pet(**invalid_pet_data)

    
    # def test_invalid_photoUrls(self):
    #     pet_data = {
    #         "id": 1,
    #         "name": "Max",
    #         "status": "available",
    #         "photoUrls": ["invalidurl", "https://example.com/image2.jpg"],
    #         "category": {"id": 1, "name": "Category1"},
    #         "tags": [{"id": 1, "name": "Tag1"}]
    #     }
    #     with self.assertRaises(ValueError):
    #         Pet(**pet_data)

if __name__ == '__main__':
    unittest.main()
