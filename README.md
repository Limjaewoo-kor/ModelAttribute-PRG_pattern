# studySpringThymeleaf

아래 3가지 어노테이션의 사용법 

@PathVariable &nbsp;
@RequestParam &nbsp;
@ModelAttribute &nbsp;


요약 -

폼 객체를 다음과 같이 각각 파라미터로 받아도되지만,
@RequestParam String itemName,
@RequestParam int price,
@RequestParam Integer quantity

@ModelAttribute를 이용하면  Item item으로 객체로 받아낼 수 있다.
또한 @ModelAttribute 사용시에는 자동으로 객체이름의 맨앞자만 소문자 ex)Item -> item으로 모델에
model.addAttribute("item",item); 까지 자동으로 해주기때문에 생략할 수 있다.
임의의 객체의 경우 @ModelAttribute 어노테이션까지도 생략은 가능하나, 헛갈릴 수 있으니 표기하는것을 추천한다.


저장하는 메소드의 경우 마지막에 리다이렉트를 시키지않으면 새로고침시 계속 저장되는 문제점이 있다.
PRG패턴(Post-Redirect-Get패턴)으로 해소가 가능하며,  RedirectAttributes 를 활용할 수 있다.
