def get_popular_names(data, gender, size: int):
    counts = {}
    for item in data:
        for name in item.get(gender, []):
            counts[name] = counts[name] + 1 if name in counts else 1
    popular_names = sorted(counts.items(), key=lambda x: (-x[1], len(x[0]), x[0]))[:size]
    return {name: count for name, count in popular_names}
