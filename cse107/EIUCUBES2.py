import math


def count_layers(k, bricks):
    result = []

    for ni in bricks:
        layer_count = int((math.sqrt(8 * ni + 1) - 1) / 4)
        result.append(layer_count)

    return result


if __name__ == "__main__":
    bricks = input()
    bricks = list(map(int, bricks.split()))
    k = bricks[0]
    del bricks[0]
    print(bricks)
    result = count_layers(k, bricks)
    print(result)
