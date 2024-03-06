def count_unpopular_names(top_names: dict, years_names: list):
    all_names = [name for sublist in [entry["girls"] for entry in years_names] for name in sublist]
    return {name: all_names.count(name) for name in all_names if name not in list(top_names.keys())}
    
