# SocketChat
## About
#### - Программа является решением домашней работы 12, и представляет из себя реализацию консольного чата с использованием сокетов и включает себя файлы :
1. Сервер: исполняемый файл, который после запуска, создает пулл из 20 потоков и начинает прослушивать порт 59898. В случае подключения клиента сервер спрашивает имя клиента сохраняет его и добавляет в общий чат.
При получении сообщения от клиента, сервер приписывает к сообщению имя клиента и рассылает всем пользователям чата (тем самым образуя общий чат между пользователями)
2. Клиент: исполняемый файл, который после запуска подключается к порту 59898 запусукает паралельное выполнение потока просмотра пришедших сообщений, а также в основном потоке считывает сообщения из консоли и отправляет их на сервер
#### - Программа является решением домашней работы на тему тетирование и включает в себя unit тестирование метода strToUp в классе CapitalizeServer

## How to run
Для демонстрации работы требуется запустить CapitalizeServer
Затем запустить некоторое число CapitalizeClient
## 
