

export var Cartao = {
    "nomeCartao": "",
    "bandeira": "",
    "numero": "",
    "anoExpira": "",
    "mesExpira": "",
    "verificador": ""
}



export var Assinatura = {
    "plan": "EBD8CBA3F6F659E114E6CF903555325B",
    "sender": {
        "name": "",
        "email": "",

        "hash" : "",
        "phone": {
            "areaCode": "",
            "number": ""
        },
        "address": {
            "street": "",
            "number": "",
            "complement": "",
            "district": "",
            "city": "",
            "state": "",
            "country": "BRA",
            "postalCode": ""
        },
        "documents": [
            {
                "type": "CPF",
                "value": ""
            }

        ]
    },
    "paymentMethod": {
        "type": "CREDITCARD",
        "creditCard": {
            "token": "",
            "holder": {
                "name": "",
                "birthDate": "",
                "phone": {
                    "areaCode": "",
                    "number": ""
                },
                "documents": [
                    {
                        "type": "CPF",
                        "value": ""
                    }
                ]
            }
        },
    }
}
