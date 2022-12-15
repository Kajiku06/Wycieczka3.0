package com.mateusz.wycieczka

class sprDATA(data: String,dzienend: String,dzienstart: String){
    //ZMIENNE
    var dzienend = dzienend
    var dzienstart = dzienstart
    var dziendzienstart = dzienstart.get(0).toString()+dzienstart.get(1).toString()
    var dziendzienend = dzienend.get(0).toString()+dzienend.get(1).toString()
    var miechstart = dzienstart.get(3).toString()+dzienstart.get(4).toString()
    var miechend = dzienend.get(3).toString()+dzienend.get(4).toString()
    var rokstart = dzienstart.get(6).toString()+dzienstart.get(7).toString()+dzienstart.get(8).toString()+dzienstart.get(9).toString()
    var rokend= dzienend.get(6).toString()+dzienend.get(7).toString()+dzienend.get(8).toString()+dzienend.get(9).toString()
    var rokdata= data.get(6).toString()+data.get(7).toString()+data.get(8).toString()+data.get(9).toString()
    var dziendata = data.get(0).toString()+data.get(1).toString()
    var miechdata = data.get(3).toString()+data.get(4).toString()


    fun sprprzeszlosc(): Boolean {
        //FUNKCJA
        if(dziendata.toInt()<=dziendzienstart.toInt())
        {
            if(miechdata.toInt()<=miechstart.toInt())
            {
                return rokdata.toInt() > rokstart.toInt()
            }
            else return true
        }
        else return true
    }
    fun sprpprzyszlosc(): Boolean {
        //FUNKCJA

            var sumalat = (rokdata.toInt() + rokend.toInt())
            if ((rokdata.toInt() + rokend.toInt()) <= (sumalat + 2)) {
                if (miechdata.toInt() <= miechend.toInt()) {
                    return dziendata.toInt() <= dziendzienend.toInt()
                } else return false
            } else return false
    }
}
