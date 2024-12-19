def find_finger(random_number):
    finger = ["cai", "tro", "giua", "ap ut", "ut", "ut", "ap ut", "giua", "tro", "cai"]
    ind = ["trai", "phai"]

    finger_number = random_number % 18

    if 10 < finger_number <= 18:
        finger_number = 20 - finger_number
    index = 1 if finger_number > 5 else 0

    print("Ngon %s cua ban tay %s" % (finger[finger_number - 1], ind[index]))


if __name__ == "__main__":
    random_number = int(input())
    find_finger(random_number)
