module my_module_a {
	exports pack1;
	exports pack2;  //기제하지 않으면 은닉되어 합친 프로젝트의 모듈 main에서 import로 불러올수 없다.
}