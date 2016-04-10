Задача - ответить верно на запрос другую форму неправильного глагола. Исходная форма и угадываемая могут настраиваться. 

1. Для запуска сервиса необходимо в качестве параметра передать номер порта
java -jar quiz-1.0-jar-with-dependencies.jar 8088
2. Для получения формы глагола нужно послать запрос: 
curl http://localhost:8088/quiz
Либо с указанием нужной формы в параметре quizVerbForm : 
curl http://localhost:8088/quiz?quizVerbForm=SECOND
3. Для проверки ответа посылается запрос в виде: 
curl -X POST -d "quizVerbForm=FIRST&answerVerb=shod&answerVerbForm=SECOND" http://localhost:8088/quiz/shoe
либо для провери с параметрами по умолчанию :
curl -X POST -d "answerVerb=shod" http://localhost:8088/quiz/shoe
4. Для получения статистики посылается запрос: 
curl http://localhost:8088/stats
