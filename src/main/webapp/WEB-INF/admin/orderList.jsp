<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/favicon.html">
<title>游乐堡后台管理系统</title>
<jsp:include page="common/css.jsp" />
</head>
<body>
          <section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             ${title}
                          </header>
                          <div id="sample_1_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row"><div class="col-sm-6"><div id="sample_1_length" class="dataTables_length"><label><select size="1" name="sample_1_length" aria-controls="sample_1" class="form-control"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> records per page</label></div></div><div class="col-sm-6"><div class="dataTables_filter" id="sample_1_filter"><label>Search: <input type="text" aria-controls="sample_1" class="form-control"></label></div></div></div><table class="table table-striped border-top dataTable" id="sample_1" aria-describedby="sample_1_info">
                          <thead>
                          <tr role="row"><th style="width: 13px;" class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label=""><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes"></th><th class="sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Username: activate to sort column ascending" style="width: 264px;">Username</th><th class="hidden-phone sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Email: activate to sort column ascending" style="width: 499px;">Email</th><th class="hidden-phone sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Points: activate to sort column ascending" style="width: 200px;">Points</th><th class="hidden-phone sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label="Joined: activate to sort column ascending" style="width: 287px;">Joined</th><th class="hidden-phone sorting" role="columnheader" tabindex="0" aria-controls="sample_1" rowspan="1" colspan="1" aria-label=": activate to sort column ascending" style="width: 327px;"></th></tr>
                          </thead>
                          
                          <tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="gradeX odd">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">Jhone doe</td>
                              <td class="hidden-phone "><a href="mailto:jhone-doe@gmail.com">jhone-doe@gmail.com</a></td>
                              <td class="hidden-phone ">10</td>
                              <td class="center hidden-phone ">02.03.2013</td>
                              <td class="hidden-phone "><span class="label label-success">Approved</span></td>
                          </tr><tr class="gradeX even">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">gada</td>
                              <td class="hidden-phone "><a href="mailto:gada-lal@gmail.com">gada-lal@gmail.com</a></td>
                              <td class="hidden-phone ">34</td>
                              <td class="center hidden-phone ">08.03.2013</td>
                              <td class="hidden-phone "><span class="label label-warning">Suspended</span></td>
                          </tr><tr class="odd gradeX">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">soa bal</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@yahoo.com">soa bal@yahoo.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">1.12.2013</td>
                              <td class="hidden-phone "><span class="label label-danger">Approved</span></td>
                          </tr><tr class="odd gradeX even">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">ram sag</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">soa bal@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">7.2.2013</td>
                              <td class="hidden-phone "><span class="label label-info">Blocked</span></td>
                          </tr><tr class="odd gradeX">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">durlab</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">test@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">03.07.2013</td>
                              <td class="hidden-phone "><span class="label label-success">Approved</span></td>
                          </tr><tr class="odd gradeX even">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">durlab</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">lorem-ip@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">05.04.2013</td>
                              <td class="hidden-phone "><span class="label label-danger">Approved</span></td>
                          </tr><tr class="odd gradeX">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">sumon</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">lorem-ip@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">05.04.2013</td>
                              <td class="hidden-phone "><span class="label label-success">Approved</span></td>
                          </tr><tr class="odd gradeX even">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">bombi</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">lorem-ip@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">05.04.2013</td>
                              <td class="hidden-phone "><span class="label label-danger">Approved</span></td>
                          </tr><tr class="odd gradeX">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">ABC ho</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">lorem-ip@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">05.04.2013</td>
                              <td class="hidden-phone "><span class="label label-success">Approved</span></td>
                          </tr><tr class="odd gradeX even">
                              <td class=" sorting_1"><input type="checkbox" class="checkboxes" value="1"></td>
                              <td class=" ">test</td>
                              <td class="hidden-phone "><a href="mailto:soa bal@gmail.com">lorem-ip@gmail.com</a></td>
                              <td class="hidden-phone ">33</td>
                              <td class="center hidden-phone ">05.04.2013</td>
                              <td class="hidden-phone "><span class="label label-success">Approved</span></td>
                          </tr></tbody></table><div class="row"><div class="col-sm-6"><div class="dataTables_info" id="sample_1_info">Showing 1 to 10 of 25 entries</div></div><div class="col-sm-6"><div class="dataTables_paginate paging_bootstrap pagination"><ul><li class="prev disabled"><a href="#">← Prev</a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li class="next"><a href="#">Next → </a></li></ul></div></div></div></div>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      <jsp:include page="common/js.jsp" />
   </body>
</html>