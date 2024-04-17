def parse(prices: list):
    parse_to_float = lambda s: float(s.replace('$', '').replace(',', '.'))
    return [parse_to_float(price) for price in prices]

def sorted_list(lst: list, reverse: bool):
    return sorted(lst, reverse=reverse)

def sort_list(lst: list, reverse):
    return sorted(lst, key=lambda i: float(i.replace("$", "")), reverse=reverse)
