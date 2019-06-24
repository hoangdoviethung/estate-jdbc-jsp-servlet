<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingURL" value="/admin-building" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách toà nhà</title>

</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>

					<li>Danh sách sản phẩm</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

						<!-- search box -->
						<!-- start form -->
						<form action="${buildingURL}" method="get">

							<div class="widget-box table-filter">
								<div class="widget-header">
									<h4 class="widget-title">Tìm kiếm</h4>
									<div class="widget-toolbar">
										<a href="#" data-action="collapse"> <i
											class="ace-icon fa fa-chevron-up"></i>
										</a>
									</div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-sm-12">
													<label>Tên sản phẩm</label>
													<div class="fg-line">
														<input type="text" class="form-control input-sm"
															name="name" value="${model.name}" />
													</div>
												</div>

											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-4">
												<label>Quận hiện có</label>
												<div class="fg-line">
													<select class="custom-select" id="sel1" name="district">
														<option value="QUAN_1">Quận 1</option>
														<option value="QUAN_2">Quận 2</option>
														<option value="QUAN_3">Quận 3</option>
														<option value="QUAN_4">Quận 4</option>
													</select>
												</div>
											</div>
											<div class="col-sm-4">
												<label>Phường</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="ward" value="${model.ward}" />
												</div>
											</div>
											<div class="col-sm-4">
												<label>Đường</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="street" value="${model.street}" />
												</div>
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-4">
												<label>Số tầng hầm</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="numberOfBasement" value="${model.numberOfBasement}" />
												</div>
											</div>
											<div class="col-sm-4">
												<label>Hướng</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="direction" value="${model.direction}" />
												</div>
											</div>
											<div class="col-sm-4">
												<label>Hạng</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="level" value="${model.level}" />
												</div>
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-3">
												<label>Diện tích từ</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="areaRentTo" value="${model.areaRentTo}" />
												</div>
											</div>
											<div class="col-sm-3">
												<label>Diện tích đến</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="areaRentFrom" value="${model.areaRentFrom}" />
												</div>
											</div>
											<div class="col-sm-3">
												<label>Giá thuê từ</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="costRentFrom" value="${model.costRentFrom}" />
												</div>
											</div>
											<div class="col-sm-3">
												<label>Giá thuê đến</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="costRentTo" value="${model.costRentTo}" />
												</div>
											</div>
										</div>

										<div class="form-group">

											<div class="col-sm-4">
												<label>Tên quản lý</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="manageName" value="${model.manageName}" />
												</div>
											</div>
											<div class="col-sm-4">
												<label>Điện thoại quản lý</label>
												<div class="fg-line">
													<input type="text" class="form-control input-sm"
														name="managePhone" value="${model.managePhone}" />
												</div>
											</div>

											<div class="col-sm-4">
												<label>Chọn nhân viên phụ trách</label>
												<div class="fg-line">
													<select class="form-control" id="sel1">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
													</select>
												</div>
											</div>

										</div>

										<div class="form-group">
											<div class="col-sm-12">
												<label>Loại tòa nhà</label>
												<div class="fg-line">
													<label class="checkbox-inline"><input
														type="checkbox" value="TANG_TRET" name="buildingTypes">Tầng
														trệt</label> <label class="checkbox-inline"><input
														type="checkbox" value="NGUYEN_CAN" name="buildingTypes">Nguyên
														căn</label> <label class="checkbox-inline"><input
														type="checkbox" value="NOI_THAT" name="buildingTypes">Nội
														thất</label>
												</div>
											</div>

										</div>

										<input type="hidden" name="action" value="LIST" />
										
											<div class="form-group">
												<div>
													<button type="submit" class="btn btn-sm btn-success">
														Tìm kiếm</button>
												</div>
											</div>
										
									</div>

								</div>
							</div>
					</div>

					<!-- End form -->
					</form>

					<!-- button add, delete -->
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container">
							<div class="dt-buttons btn-overlap btn-group">
								<a flag="info"
									class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Thêm tòa nhà'
									href='<c:url value="/admin-building?action=EDIT"/>'> <span><i
										class="fa fa-plus-circle bigger-110 purple"></i></span>
								</a>
								<button type="button"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Xóa tòa nhà'>
									<span><i class="fa fa-trash-o bigger-110 pink"></i></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Table -->
			<div class="row">
				<div class="col-xs-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Tên sản phẩm</th>
								<th>Địa chỉ</th>
								<th>Quản lý</th>
								<th>SDT quản lý</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>John</td>
								<td>Doe</td>
								<td>john@example.com</td>
								<td>Mary</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
	</div>
	</div>
	<!-- /.main-content -->
</body>
</html>