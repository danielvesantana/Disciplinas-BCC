def calculate_love_score(name):
    true_value = 0
    love_value = 0
    i = 0

    for i in range(len(name)):
        if name[i] == 'T' or name[i] == 'R' or name[i] == 'U' or name[i] == 'E':
            true_value += 1
        
        if name[i] == 'L' or name[i] == 'O' or name[i] == 'V' or name[i] == 'E':
            love_value += 1
                    
    return true_value, love_value
    
true_value1, love_value1 = calculate_love_score("Angela Yu".upper())
true_value2, love_value2 = calculate_love_score("Jack Bauer".upper())

true_value = true_value1 + true_value2
love_value = love_value1 + love_value2


print(f"{true_value}{love_value}")