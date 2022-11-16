delete from train.customer_goods cg
 where cg.customer_id = :customerId
   and cg.good_id = :goodId;