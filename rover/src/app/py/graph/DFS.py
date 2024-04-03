class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def dfb(node):
    if node is not None:
        print(node.value)
        dfb(node.left)
        dfb(node.right)

def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    print(start, end= ' ')
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}

print("Depth-First Search Traversal:")
dfs(graph, 'A')

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print("Depth-First Binary Tree Traversal:")
dfb(root)