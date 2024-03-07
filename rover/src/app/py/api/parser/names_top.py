def get_popular_names(data, gender, size: int, sort_abc=None, sort_len=None):
    
    counts = {}
    for item in data:
        for name in item.get(gender, []):
            counts[name] = counts[name] + 1 if name in counts else 1
    popular_names = sorted(counts.items(), key=order_key(sort_abc, sort_len))[:size]
    return {name: count for name, count in popular_names}


def order_key(sort_abc, sort_len):
    if sort_abc and sort_len: return lambda x: (-x[1], len(x[0]), x[0])
    elif sort_len: return lambda x: (-x[1], len(x[0]))
    elif sort_abc: return lambda x: (-x[1], x[0])
    else: return lambda x: (-x[1])
        
