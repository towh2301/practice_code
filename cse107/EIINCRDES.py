def check_order(order):
    signal = 1
    for i in range(len(order) - 1):
        if not order[i] > order[i + 1]:
            signal = 0
            break

    if signal == 1:
        return "decreasing"

    for i in range(len(order) - 1):
        if not order[i] < order[i + 1]:
            return "none"
    return "increasing"


if __name__ == "__main__":
    length = int(input())
    order = input()

    order = list(map(int, order.split()))

    result = check_order(order)
    print(result)
