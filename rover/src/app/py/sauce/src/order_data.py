class OrderData:
    user_data = [["", "Ivanov", "1241515", "Error: First Name is required"],
                 ["Vasia", "", "1241515", "Error: Last Name is required"],
                 ["Vasia", "Ivanov", "", "Error: Postal Code is required"]]

    user_data_with_valid_credential = ["Dan", "Ivanov", "1241515"]
    successful_message = "Thank you for your order!"
