def solve(m, n):
    if m == 0:
        return n + 1
    elif m == 1:
        return 2*m + n
    elif m == 2:
        return m + (2*n + 1)
    elif m == 3:
        return 2**(n+3) - 3
    elif n == 0:
        return solve(m - 1, 1) 
    else:
        return solve(m - 1, solve(m, n - 1))

if __name__ == "__main__":
    m, n = map(int, input().split())
    print(solve(m, n))
