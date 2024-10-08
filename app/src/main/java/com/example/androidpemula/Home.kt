package com.example.androidpemula

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newItemList: ArrayList<ListSenjata>
    private lateinit var imgSenjata: Array<Int>
    private lateinit var titleSenjata: Array<String>
    private lateinit var descSenjata: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val listViews =  inflater.inflate(R.layout.fragment_home, container, false)

        imgSenjata = arrayOf(
            R.drawable.ar_1,
            R.drawable.ar_2,
            R.drawable.ar_3,
            R.drawable.ar_4,
            R.drawable.ar_5,
            R.drawable.smg_6,
            R.drawable.smg_7,
            R.drawable.sr_8,
            R.drawable.sr_9,
            R.drawable.sg_10
        )

        titleSenjata = arrayOf(
            "AR-M416",
            "AR-SCAR-L",
            "AR-G36C",
            "AR-AKM",
            "AR-AUG-A3",
            "SMG-UMP45",
            "SMG-Micro UZI",
            "SR-Kar98K",
            "SR-M24",
            "SG-DBS"
        )

        descSenjata = arrayOf(
            "The AR-M416 is a carbine-length assault rifle that is known for its accuracy, reliability, and versatility. It is chambered in 5.56x45mm NATO and is used by militaries and law enforcement agencies around the world. The AR-M416 is a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. It is also known for its low recoil and easy handling, making it a popular choice for both military and civilian shooters.",
            "The AR-SCAR-L is a modular assault rifle designed by FN Herstal for the United States Special Operations Command (SOCOM). It is chambered in 5.56x45mm NATO and is known for its accuracy, reliability, and versatility. The AR-SCAR-L is a lightweight rifle that is easy to carry and maneuver, making it ideal for close-quarters combat and urban operations. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The AR-SCAR-L is a popular choice among military and law enforcement agencies around the world.",
            "The AR-G36C is a compact assault rifle designed by Heckler & Koch for the German Army. It is chambered in 5.56x45mm NATO and is known for its accuracy, reliability, and versatility. The AR-G36C is a lightweight rifle that is easy to carry and maneuver, making it ideal for close-quarters combat and urban operations. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The AR-G36C is a popular choice among military and law enforcement agencies around the world.",
            "The AR-AKM is a modernized version of the classic AK-47 assault rifle. It is chambered in 7.62x39mm and is known for its reliability, ruggedness, and simplicity. The AR-AKM features a number of improvements over the original AK-47, such as a polymer magazine, a longer barrel, and a different handguard. It is also known for its low recoil and easy handling, making it a popular choice among military and law enforcement agencies around the world.",
            "The AR-AUG-A3 is a bullpup assault rifle designed by Steyr Mannlicher for the Austrian Army. It is chambered in 5.56x45mm NATO and is known for its accuracy, reliability, and versatility. The AR-AUG-A3 is a lightweight rifle that is easy to carry and maneuver, making it ideal for close-quarters combat and urban operations. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The AR-AUG-A3 is a popular choice among military and law enforcement agencies around the world.",
            "The SMG-UMP45 is a submachine gun designed by Heckler & Koch for the German Army. It is chambered in .45 ACP and is known for its accuracy, reliability, and versatility. The SMG-UMP45 is a lightweight and compact weapon that is easy to carry and maneuver, making it ideal for close-quarters combat and urban operations. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The SMG-UMP45 is a popular choice among military and law enforcement agencies around the world.",
            "The SMG-Micro UZI is a submachine gun designed by Israel Military Industries (IMI). It is chambered in 9x19mm Parabellum and is known for its accuracy, reliability, and versatility. The SMG-Micro UZI is a lightweight and compact weapon that is easy to carry and maneuver, making it ideal for close-quarters combat and urban operations. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The SMG-Micro UZI is a popular choice among military and law enforcement agencies around the world.",
            "The Kar98k is a bolt-action rifle that served as the standard infantry weapon for the German Wehrmacht during World War II. Designed by Mauser, it's renowned for its reliability, accuracy, and powerful 7.92x57mm Mauser cartridge. The Kar98k's distinctive features include a five-round internal box magazine, a Mannlicher-style bolt, and a characteristic S-shaped bolt handle. Its design emphasizes simplicity and efficiency, making it a favored choice among military historians and firearms enthusiasts alike. Even today, the Kar98k is still used in various military and sporting contexts, and it remains a popular choice for historical reenactments and target shooting.",
            "The SR-M24, also known as the M24 Sniper Weapon System (SWS), is a bolt-action rifle that has served as the standard sniper rifle for the United States Army since 1988. It is a military and police version of the Remington Model 700 rifle, chambered for the 7.62x51mm NATO cartridge. The M24 is known for its accuracy, reliability, and versatility, and has been used in a variety of combat situations around the world. It is a popular choice among military and law enforcement agencies, and is also used by civilian marksmen for long-range target shooting.",
            "The SG-DBS is a semi-automatic double-barrel shotgun designed by Beretta. It is chambered for 12-gauge shells and is known for its power, reliability, and versatility. The SG-DBS is a short and compact weapon that is easy to carry and maneuver, making it ideal for close-quarters combat and home defense. It is also a modular weapon that can be customized with a variety of accessories, such as different barrels, handguards, and optics. The SG-DBS is a popular choice among military and law enforcement agencies around the world, as well as among civilian shooters."
        )

        newRecyclerView = listViews.findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newItemList = ArrayList()
        for (itemList in imgSenjata.indices){
            val listItem = ListSenjata(imgSenjata[itemList], titleSenjata[itemList], descSenjata[itemList])
            newItemList.add(listItem)
        }

        val adapter = MyAdapter(newItemList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemOnClick(position: Int) {
                val intent = Intent(requireContext(), Detail::class.java)
                intent.putExtra("titleImg", newItemList[position].gambarSenjata)
                intent.putExtra("text_title", newItemList[position].judulSenjata)
                intent.putExtra("text_description", newItemList[position].deskSenjata)
                startActivity(intent)
            }
        })
        return listViews
    }
}