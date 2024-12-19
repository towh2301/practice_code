def count_grade(grades, columns, names):
    list_grade = {90, 85, 80, 75, 70, 65, 60, 55, 53, 52, 50, 0}
    list_char = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"}

    avg_grade = sum(grades) / columns
    for s in list_grade:
        if avg_grade >= s:
            return list_char[s.__index__]


if "__name__" == "__main__":
    insert = map(str, input().split())
    students = insert[0]
    columns = insert[1]
