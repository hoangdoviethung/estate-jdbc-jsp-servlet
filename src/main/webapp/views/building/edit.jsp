<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="builddingAPI" value="/api-admin-building" />
<c:url var="buildingURL" value="/admin-building" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li><a href="#">Sản phẩm</a></li>
					<li>Thêm sản phẩm</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form" id="formEdit">
							<div class="form-group ">
								<label class="col-sm-3 "> Tên sản phẩm </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" name="name"
											value="${model.name}" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-3">
									<label><b>Hình ảnh cho sản phẩm</b></label>
								</div>
								<div class="col-sm-3">
									<div class="fg-line">
										<label class="block clearfix"> <input type="file"
											name="file" class="btn btn-info">
										</label>
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="fg-line">
									<label class="col-sm-12 "> Người quản lý Sản phẩm </label>
								</div>
							</div>

							<div class="form-group distance">
								<label class="col-sm-12 control">Quận </label>
								<div class="col-sm-12">
									<div class="fg-line">
										<select class="custom-select" id="sel1" name="district">
											<option value="">Chọn quận</option>
											<c:forEach var="item" items="${districs}">
												<option value="${item.key}"
													${item.key == model.district ? 'selected' : ''}>${item.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phường </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" name="ward"
											value="${model.ward}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Đường </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" name="street"
											value="${model.street}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Hướng </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="direction" value="${model.direction}" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Hạng </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" name="level"
											value="${model.level}" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Số tầng hầm </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="numberOfBasement" value="${model.numberOfBasement}" />
									</div>
								</div>
							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Diện tích thuê </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="rentArea" value="${model.rentArea}" />
									</div>
								</div>

							</div>
							<div class="form-group distance">
								<label class="col-sm-3 "> Diện tích sàn </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="buildingArea" value="${model.buildingArea}" />
									</div>
								</div>

							</div>
							<div class="form-group distance">
								<label class="col-sm-3 "> Giá thuê </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="costRent" value="${model.costRent}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Tên quản lý </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="managerName" value="${model.managerName}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> SDT quản lý </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="managerPhone" value="${model.managerPhone}" />
									</div>
								</div>

							</div>



							<div class="form-group distance">
								<label class="col-sm-3 "> Loại tòa nhà </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<c:forEach var="item" items="${buidingTypes}">
											<label class="checkbox-inline"><input type="checkbox"
												value="${item.key}" name="buildingTypes"
												${fn:contains(fn:join(model.buildingTypes,',') ,item.key) ? 'checked' : ''}>${item.value}</label>
										</c:forEach>

									</div>
								</div>
							</div>

							<input type="hidden" name="id" value="${model.id}"
								id="buildingId" />
						</form>
						<div class="form-group">
							<c:if test="${empty model.id}">
								<div class="col-sm-1 col-sm-offset-3">
									<button class="btn btn-success" id="btnAddOrUpdateBuilding">Thêm
										sản phẩm</button>
								</div>
							</c:if>
							<c:if test="${not empty model.id}">
								<div class="col-sm-1 col-sm-offset-3">
									<button class="btn btn-success" id="btnAddOrUpdateBuilding">Cập
										nhật sản phẩm</button>
								</div>
							</c:if>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<script type="text/javascript">
		$("#btnAddOrUpdateBuilding").click(function() {
			addOrUpdateBuilding();
		});

		function addOrUpdateBuilding() {
			var buildingId = $('#buildingId').val();
			var formData = $('#formEdit').serializeArray();
			var data = {};
			var buildingTypes = [];
			$.each(formData, function(index, v) {
				if (v.name == 'buildingTypes') {
					buildingTypes.push(v.value);
				} else {
					data["" + v.name + ""] = v.value;
				}
			});
			data['buildingTypes'] = buildingTypes;
			if (buildingId == '') {
				addBuilding(data);
			} else {
				editBuilding(data, buildingId);
			}
		}

		function addBuilding(data, id) {
			$
					.ajax({
						url : '${builddingAPI}',
						data : JSON.stringify(data),
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',

						success : function(data) {
							window.location.href = "${buildingURL}?action=EDIT&id="
									+ data.id + "&message=insert_success";
						},
						error : function() {
							window.location.href = "${buildingURL}?action=LIST&message=insert_success";
						}
					});
		}
		function editBuilding(data, id) {
			$
					.ajax({
						url : '${builddingAPI}',
						data : JSON.stringify(data),
						type : 'PUT',
						contentType : 'application/json',
						success : function(data) {
							window.location.href = "${buildingURL}?action=EDIT&id="
									+ id + "&message=update_success";
						},
						error : function() {
							window.location.href = "${buildingURL}?action=LIST&message=errorsystem";
						}
					});
		}
	</script>
</body>
</html>



