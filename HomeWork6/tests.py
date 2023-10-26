import pytest

from HW6 import NumsLists


@pytest.fixture
def list1():
    return [1, 2, 3, 4, 5]


@pytest.fixture
def list2():
    return [2, 3, 8, 5, 9]

# Проверка средних значений, если один или оба списка пустые
@pytest.mark.parametrize('list1, list2, result', [([1, 2, 3], [], (2, 0)), ([], [1, 2, 3], (0, 2)), ([], [], (0, 0))])
def test_get_empty_lists_averages(list1, list2, result):
    
    nums_list = NumsLists(list1, list2)
    assert nums_list.get_lists_averages() == result

# Проверка средних значений, если один или оба списка имеют только один элемент
@pytest.mark.parametrize('list1, list2, result', [([1, 2, 3], [5], (2, 5)), ([5], [1, 2, 3], (5, 2)), ([5], [5], (5, 5))])
def test_get_one_elemented_lists_averages(list1, list2, result):
    nums_list = NumsLists(list1, list2)
    assert nums_list.get_lists_averages() == result

# Проверка сообщения когда среднее значение первого списка больше второго
def test_first_average_more(list1, list2, capfd):
    nums_list = NumsLists(list2, list1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Первый список имеет большее среднее значение'

# Проверка сообщения когда среднее значение второго списка больше первого
def test_second_average_more(list1, list2, capfd):
    nums_list = NumsLists(list1, list2)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Второй список имеет большее среднее значение'

# Проверка сообщения когда средние значения списков равны
def test_equal_averages(list1, capfd):
    nums_list = NumsLists(list1, list1)
    nums_list.compare_averages()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Средние значения равны'