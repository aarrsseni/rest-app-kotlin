- Adding person
http://127.0.0.1:8080/person
```
{
        "firstName": "Vasya",
        "lastName": "Pupkin",
        "patronymic": "Ivanovich",
        "dateOfBirth": "1999-03-03",
        "additionalPhones": [{
                "id": 3,
                "phoneNumber": "1111111"
            }
        ],
        "additionalAddresses": [
        	{
            "id": 2,
            "description": "Grodno"
        	}
        ],
        "mainPhone": {
            "id": 2,
            "phoneNumber": "7777777"
        },
        "mainAddress": {
        	"id": 1,
            "description": "Minsk"
        },
        "mainJob": {
        	"id": 2,
            "description": "Gazprom"
        },
        "additionalJobs": []
}
```

- Adding phone
http://127.0.0.1:8080/phone
```
{
    "phoneNumber": "9871234"
}
```

- Adding job
http://127.0.0.1:8080/job
```
{
    "description": "Bank"
}
```

- Adding address
http://127.0.0.1:8080/address
```
{
    "description": "Grodno"
}
```

- Adding phone to contact
PUT http://127.0.0.1:8080/person/{id}/phone
```
{
    "id": "{id}",
    "phoneNumber": "9871234"
}
```
- Adding address to contact
PUT http://127.0.0.1:8080/person/{id}/address
```
    {
        "id": "{id}",
        "description": "description"
    }
```