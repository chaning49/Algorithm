-- 코드를 입력하세요
SELECT B.title, B.board_id, R.reply_id, R.writer_id, R.contents, date_format(R.created_date, '%Y-%m-%d') as created_date
FROM used_goods_board as B, used_goods_reply as R
WHERE B.board_id = R.board_id and year(B.created_date) = 2022 and month(B.created_date) = 10
ORDER BY R.created_date, B.title;