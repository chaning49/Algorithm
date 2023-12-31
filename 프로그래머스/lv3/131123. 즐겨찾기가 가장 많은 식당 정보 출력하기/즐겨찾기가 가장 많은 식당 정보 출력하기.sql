-- 코드를 입력하세요
SELECT A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES
FROM REST_INFO AS A
JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO AS B
    GROUP BY FOOD_TYPE
) T
ON T.FOOD_TYPE = A.FOOD_TYPE AND T.FAVORITES = A.FAVORITES
ORDER BY FOOD_TYPE DESC;