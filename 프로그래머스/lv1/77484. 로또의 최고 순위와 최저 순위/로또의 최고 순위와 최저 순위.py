def solution(lottos, win_nums):
    sequence = [6, 6, 5, 4, 3, 2, 1]
    chk_n = 0
    chk_z = lottos.count(0)
    for w in win_nums:
        if w in lottos:
            chk_n += 1
    return sequence[chk_z + chk_n], sequence[chk_n]