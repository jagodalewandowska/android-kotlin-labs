package utp.edu.lab9.model

data class Photo(val id:Int,
                 val title:String,
                 val year:String,
                 val author:String,
                 val place:String,
                 val description:String,
                 val images:List<String>,
)
fun getPhotos():List<Photo>
{
    return listOf(
        Photo(
            id= 1,
            title = "Morzine",
            year = "2022",
            author = "Jagoda Lewandowska",
            place = "Morzine, Francja",
            description = "Morzine to ośrodek narciarski we francuskich Alpach, niedaleko granicy ze Szwajcarią.",
            images = listOf("https://cdn.discordapp.com/attachments/710875492881793045/1109159570653319238/IMG-20220714-WA00111.jpg",
                "https://cdn.discordapp.com/attachments/710875492881793045/1109159571253104662/IMG-20220713-WA0014.jpg",
                "https://cdn.discordapp.com/attachments/710875492881793045/1109159570976284822/IMG-20220713-WA0012.jpg",
                "https://cdn.discordapp.com/attachments/710875492881793045/1109159571492196463/IMG-20220714-WA0006.jpg"
            )
        ),
        Photo(
            id= 2,
            title = "Londyn",
            year = "2021",
            author = "Jagoda Lewandowska",
            place = "Londyn, Anglia",
            description = "Londyn, stolica Anglii i Wielkiej Brytanii, to miasto XXI wieku.",
            images = listOf("https://i.imgur.com/6reGEzt.jpg", "https://i.imgur.com/10liEgu.jpg",
            "https://i.imgur.com/91EZp2x.jpg", "https://i.imgur.com/jH8EvsK.jpg")
        ),
        Photo(
            id= 3,
            title = "Cambridge",
            year = "2022",
            author = "Jagoda Lewandowska",
            place = "Cambridge, Anglia",
            description = "Cambridge to uniwersyteckie miasto położone 80 km na północ od Londynu.",
            images = listOf("https://cdn.discordapp.com/attachments/710875492881793045/1109159594447614073/IMG-20220818-WA00121.jpg",
            "https://cdn.discordapp.com/attachments/710875492881793045/1109159594187571200/IMG-20220818-WA0009.jpg",
            "https://cdn.discordapp.com/attachments/710875492881793045/1109159593956888636/IMG-20220818-WA00081.jpg")
        ),
        Photo(
            id= 4,
            title = "Spływ kajakami",
            year = "2021",
            author = "Jagoda Lewandowska",
            place = "Tleń, Polska",
            description = "Spływ kajakowy Wdą i Brdą przez piękne, pomorskie tereny z pięknymi krajobrazami.",
            images = listOf("https://cdn.discordapp.com/attachments/710875492881793045/1109159534523588759/IMG-20220623-WA0075.jpg",
            "https://cdn.discordapp.com/attachments/710875492881793045/1109159534221594777/IMG-20220623-WA0061.jpg",
            "https://cdn.discordapp.com/attachments/710875492881793045/1109159533823139931/IMG-20220623-WA0068.jpg")
        ),
        Photo(
            id= 5,
            title = "Pontcysyllte Aqueduct",
            year = "2021",
            author = "Jagoda Lewandowska",
            place = "Llangollen, UK",
            description = "Akwedukt Pontcysyllte to akwedukt, który prowadzi przez rzekę Dee w Walii.",
            images = listOf("https://i.imgur.com/ITikTk3.jpg", "https://i.imgur.com/jgsCZ76.jpg",
            "https://i.imgur.com/OYedOgq.jpg", "https://i.imgur.com/XQCYcqb.jpg")
        ),
        Photo(
            id= 6,
            title = "York",
            year = "2021",
            author = "Jagoda Lewandowska",
            place = "York, UK",
            description = "York to otoczone murami miasto w północno-wschodniej Anglii.",
            images = listOf("https://i.imgur.com/SArGP13.jpg", "https://i.imgur.com/pu8DSxp.jpg",
            "https://i.imgur.com/O33FpJ3.jpg", "https://i.imgur.com/Jg0OKHd.jpg")
        )
    )
}