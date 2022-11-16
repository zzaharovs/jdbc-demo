select concat(c.lastname, ' ' , c.firstname) as fullname,
       g.product_name,
       concat(g.quantity_in_one, ' ', g.measure) as measure,
       concat(g.amount, ' ', g.currency) as price_for_one,
       concat(g.amount * cg.count, ' ', g.currency) as total_sum,
       cg.count
  from train.customers c
  join train.customer_goods cg on c.id = cg.customer_id
  join train.goods g on cg.good_id = g.id
 where upper(c.lastname) = upper(:lastname);

