# Задание 1. Создайте программу на Python или Java, которая принимает два 
# списка чисел и выполняет следующие действия:
# a. Рассчитывает среднее значение каждого списка.
# b. Сравнивает эти средние значения и выводит соответствующее сообщение

class NumLists:
    def __init__(self, list1, list2):
        self.list1 = list1
        self.list2 = list2

    def get_lists_averages(self) -> tuple[float, float]:
        average1 = 0
        if self.list1:
            average1 = sum(self.list1) / len(self.list1)

        average2 = 0
        if self.list2:
            average2 = sum(self.list2) / len(self.list2)

        return average1, average2

    def compare_averages(self) -> None:
        avrg1, avrg2 = self.get_lists_averages()
        if avrg1 > avrg2:
            print('Первый список имеет большее среднее значение')
        elif avrg1 < avrg2:
            print('Второй список имеет большее среднее значение')
        else:
            print('Средние значения равны')