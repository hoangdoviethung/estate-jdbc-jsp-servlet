<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

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

				<div class="widget-body">
					<div class="widget-main">
						<div class="form-horizontal">
							<div class="form-group ">
								<label class="col-sm-3 "> Tên sản phẩm </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="fg-line">
									<label class="col-sm-12 "> Người quản lý Sản phẩm </label>
								</div>
							</div>


							<div class="form-group distance">
								<label class="col-sm-3 control">Quận </label>
								<div class="col-sm-2">
									<div class="fg-line">
										<select class="form-control" id="sel1">
											<option>Quận Bình Thạch</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
										</select>
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Phường </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Đường </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
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
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> Diện tích sàn </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Hướng </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Hạng </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>


							<div class="form-group distance">
								<label class="col-sm-3 "> Diện tích thuê </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
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
										<input type="text" class="form-control input-sm" />
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
										<input type="text" class="form-control input-sm" />
									</div>
								</div>

							</div>

							<div class="form-group distance">
								<label class="col-sm-3 "> SDT quản lý </label>
								<div class="col-sm-9">
									<div class="fg-line">
										<input type="text" class="form-control input-sm" />
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
										<label class="checkbox-inline"><input type="checkbox"
											value="">Option1</label> <label class="checkbox-inline"><input
											type="checkbox" value="">Option2</label> <label
											class="checkbox-inline"><input type="checkbox"
											value="">Option3</label>
									</div>
								</div>
							</div>
							<div class="">
								<button type="button" >Hủy Bỏ</button>
								<button type="button" >Thêm sản phẩm</button>
							</div>
						</div>
					</div>
					<!-- /.main-content -->
</body>
</html>