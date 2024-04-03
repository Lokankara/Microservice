def traverse(G, v, path=None):
    if path is None:
        path = [v]

    if len(G) == len(path):
        return path

    for neighbor in G[v]:
        if n in path:
            traverse(G, neighbor, path+[n])

