import allure
import re

class BasicValidator:
    @allure.description("Verify that the email is valid")
    def is_valid_email(self, email):
        """
        Validate an email addressBook.

        :param email: The email addressBook to validate.
        :return: True if the email is valid, False otherwise.
        """
        email_regex = r'[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+'
        return bool(re.match(email_regex, email))

    @allure.description("Verify that the status is valid")
    def is_valid_status(self, status):
        """
        Validate a status value.

        :param status: The status value to validate.
        :return: True if the status is valid, False otherwise.
        """
        valid_statuses = {'available', 'pending', 'sold'}
        return status in valid_statuses