# graphql-springboot
url: http://localhost:8080/graphiql

POST REQUEST 
=============
1. Post Order With Get Detail
------------------------------
mutation{feedOrder(orderId:15,orderNumber:"eoeo22",orderTitle:"",orderText:""
,orderCategory:"",orderStatus:"A",orderTotal:22.0,items:{
  itemId:11111,orderId:10,itemName:"sdfsd",
  itemNumber:"NNN2w3432",itemStatus:"A"
}) {
  orderId
  orderCategory
  orderStatus
  orderTotal
}}


GET REQUESTS
=============
1. Order Search
-----------------
{
  orderSearch(orderId:9){
    orderId
    orderText
    items{
      itemId
      itemName
    }
  }
}

2. Item Search
----------------
{
 itemSearch(itemId:90){
  itemNumber
  itemName
}
}

3. All Items
----------------
{
  allItems{
    itemId
    itemPrice
    itemStatus
  }
}
