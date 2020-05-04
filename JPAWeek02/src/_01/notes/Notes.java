package _01.notes;

public enum Notes {

}

//Entity RelationShip
//bir iliþkide olabilecek kavramlar

// -Role
// -Directionality
// -Cardinality
// -Ordinality/ Optionality

//Role kavramý :
//bir iliþki/relatikonship için 2 taraf olmasý gerekli..
//birbiri ile iliþkili 2 tane Entity vardýr.
//Her entity'nin rolu olacaktýr. '


//Directionality
//bir iliskide , bir entity'inin , diger entinty gostermesi/isaret etmesi.

//2 entity'den  sadece biri digerini gosteriyorsa ; unidirectional
//ikisi de birbirini gosteriyorsa , bi directional

//Cardinality
//"nicalik"

//bir iliski ;

//onetoone
//onetomany
//manytoone
//manytomany

//Employee - Deparment (many employee - one department)
//Employee - Project (many employee - many project)
//Employee - Phone ( one employee - many phone )

//- Ordinality/Optionality
//Customer ve BillingInfo table/entity olsun
//diyelim ki n11.com a kayit olduk (customer kaydi olustu)
//henuz alisveris yapmadik. ortada billinginfo yok!
//tersten bakacak olursak ;
//ortada bir billinginfo varsa bu durumda customer kaydi olmak zorunda!

//BillingInfo -> Optional/Ordinality

