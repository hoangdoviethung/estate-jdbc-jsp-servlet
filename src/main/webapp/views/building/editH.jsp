<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-admin-building" />
<c:url var="buildingURL" value="/admin-building" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh sửa thông tin sản phẩm</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li>Sản phẩm</li>
					<li>Chỉnh sửa thông tin Sản phẩm</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form id="formEdit">
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
								<label class="col-sm-3 "> Kết cấu </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>
								<div class="col-sm-12"></div>
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
								<label class="col-sm-3 "> Diện tích sàn </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="buildingArea" value="${model.buildingArea}" />
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
								<label class="col-sm-3 "> Diện tích thuê </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="rentArea" value="${model.rentArea}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Mô tả diện tích </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<textarea class="form-control input-sm" rows="5" id="comment"></textarea>
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
								<label class="col-sm-3 "> Mô tả giá </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phí dịch vụ </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Phí ô tô </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phí mô tô </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phí ngoài giờ </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Tiền điện </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Đặt cọc </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Thanh toán </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Thời gian thuê </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Thời gian trang trí</label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Tên quản lý </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="manageName" value="${model.managerName}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> SDT quản lý </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm"
											name="managePhone" value="${model.managerPhone}" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phí môi giới </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
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
						<div class="row text-center btn-addsp">
							<c:if test="${empty model.id}">
								<button class="btn btn-success" id="bntAddOrUpdateBuilding">Thêm
									tòa nhà</button>
							</c:if>
							<c:if test="${not empty model.id}">
								<button class="btn btn-success" id="bntAddOrUpdateBuilding">Cập
									nhật tòa nhà</button>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->


	<!-- 
		  $("#bntAddOrUpdateBuilding").click(function(){
		    addOrUpdateBuilding();
		  });
		  
		  function addOrUpdateBuilding(){
			  var buildingId= $('#buildingId').val();
			  var formData = $('#formEdit').serializeArray();
			  var data = {};
			  var buildingTypes = [];
			  $.each(formData, function (index, v) {
				 if(v.name == 'buildingTypes'){
					 buildingTypes.push(v.value);
			  	}else{
			  	  data[""+v.name+""] = v.value;	// ""
			  	}
			});
			  data['buildingTypes'] = buildingTypes;
			  
			  if(buildingId == ''){
				  addBuilding(data,buildingId);
			  }else{
				  editBuilding(data,buildingId);
			  }	  
		  }
		 function addBuilding(data,id){
			 $.ajax({
				 url: '${buildingAPI}',
				 data: JSON.stringify(data),
				type ='POST',
				contentType : 'application/json',
				 dataType: 'json',
				 success: function(data) {				
				 window.location.href = "${buildingURL}?action=EDIT&id="+id+"&message=insert_success";
				 },
				 error: function() {
					 window.location.href = "${buildingURL}?action=LIST&message=error_system";
					 }
				 });
		  }
		 function editBuilding(data,id){
				
		  }	
		 -->

	<script type="text/javascript">
		$("#bntAddOrUpdateBuilding").click(function() {
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

		function addBuilding(data) {
			$.ajax({
						url : '${builddingAPI}',
						data : JSON.stringify(data),
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',

						success : function(data) {
							window.location.href = "${buildingURL}?action=EDIT&id="
									+ data.id + "&message=insert_successADD";
						},
						error : function() {
							window.location.href = "${buildingURL}?action=LIST&message=errorsystemADD";
						}
					});
		}
		function editBuilding(data, id) {
			$.ajax({
						url : '${builddingAPI}',
						data : JSON.stringify(data),
						type : 'PUT',
						contentType : 'application/json',
						success : function(data) {
							window.location.href = "${buildingURL}?action=EDIT&id="
									+ id + "&message=update_successEDIT";
						},
						error : function() {
							window.location.href = "${buildingURL}?action=LIST&message=errorsystemEDIT";
						}
					});
		}
	</script>
</body>
</html>