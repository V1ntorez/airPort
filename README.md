# airPort
якщо щось буде цікавите можете написати зможу помогти розібратись
перед кожною силкою прописуйте localhost:8080/airport/

air-companies - переходите по силці, там все зрозуміло

air-plane-move-between-company/{idAirPlane}/{idAirCompany} - міняє самальотики між компаніями
в місця {idAirPlane}{idAirCompany} вводите відповідне Ід

get-all-flight-by-status-and-name-company/{status}/{name} - використовуєте для пошуку рейсів в відповідній компанії по статусу(всі дані не виводив, вивів тільки ід рейсу) 
замість {status}/{name} вводите {"n"}{імя компанії}  замість n  
n==1 це актив
n==2 це завершений
n==3 це зариманий
n==4 це очікує

 get-all-flight-in-active-and-started-24-hour-ago - для пошуку рейсів які активні та вилетіли понад 24 години тому

  new-air-plane - там все зрозуміло

  new-flight - теж все зрозуміло

  change-flight-status/{idFlight}/{status} - для зміни статусу по ид рейсу
  {idFlight}/{status} == {ид польоту}{"n"} замість n
  n==1 це актив
  n==2 це завершений
  n==3 це зариманий
  n==4 це очікує

  find-all-flights-in-completed-and-different-between-time ще не завершив 
