INSERT INTO payment.credit_entry(customer_id, balance,created_by, created_at)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 50000.00, 'system', TIMESTAMP '2024-05-22 15:23:54');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb41', 100.00, 'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'd215b5f8-0249-4dc5-89a3-51fd148cfb41', 600.00, 'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'd215b5f8-0249-4dc5-89a3-51fd148cfb41', 200.00, 'DEBIT');


INSERT INTO payment.credit_entry(customer_id, balance,created_by, created_at)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb43', 100.00, 'system', TIMESTAMP '2024-05-22 15:23:54');
INSERT INTO payment.credit_history(id, customer_id, amount, type)
	VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'd215b5f8-0249-4dc5-89a3-51fd148cfb43', 100.00, 'CREDIT');



