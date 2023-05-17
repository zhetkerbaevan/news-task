# news-task-strong-team
Project made by Zhetkerbaeva Nazerke
Three tables Sources, News, Topics were created in the PostgreSQL database. The "Sources" and "Topics" tables are related to the "News" table by a "many to one" relationship, that is, the Source and title may contain several news, but the news can have only one name and source.
You need to go to the url - http://localhost:8080/api/login through 
login: admin,
password: admin
and you will be given access and refresh token. Then, through the same url, you can make different requests and check all the methods.
Also, 3 tasks were completed, which should create a text file every midnight with the number of news from each source.
