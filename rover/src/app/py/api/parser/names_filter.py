def filter_names(data, size):
    return {name: count for name, count in data.items() if count > size - 1}
