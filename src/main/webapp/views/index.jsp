<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Currency Converter</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	</head>
	<body>
		<div class="container col-md-10 col-md-offset-1">
			<div class="panel panel-primary">
				<div class="panel-heading">Currency Converter</div>
				<div class="panel-body">
					<form action="exchange.php" method="post">
						<div class="form-group">
							<label class="control-label">Amount: </label>
							<input value="${model.amount}" class="form-control" type="text" name="amount" required="required" />
						</div>
						<div class="form-group">
							<label class="control-label">From: </label>
							<select name="fromCurrency" class="form-control" name="currency">
								<c:forEach  items="${model.list}" var="item">
									<option value="${item.exchangeByUs}" <c:if test="${item.exchangeByUs eq model.fromCurrency}">selected</c:if>>${item.currency}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label class="control-label">To: </label>
							<select name="toCurrency" class="form-control" name="currency">
								<c:forEach items="${model.list}" var="item">
									<option value="${item.exchangeByUs}" <c:if test="${item.exchangeByUs eq model.toCurrency}">selected</c:if>>${item.currency}</option>
									<%-- <option value="${item.exchangeByUs}">${item.currency}</option> --%>
								</c:forEach>
							</select>
						</div>
						<div>
							<label>Result: </label>
							<label>${model.result}</label>
						</div>
						<div>
							<button class="btn btn-primary" type="submit">Change</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>