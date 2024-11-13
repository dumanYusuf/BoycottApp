Bu uygulama, Clean Architecture prensiplerine uygun olarak tasarlanmış,  Cloud Firestore veritabanı kullanılarak geliştirilmiş bir bilgilendirme platformudur. Hilt kullanılarak bağımlılık yönetimi sağlanmış ve Use Case katmanı aracılığıyla Repository ve ViewModel arasındaki bağlantılar kurulmuştur.

Uygulama açıldığında, ana sayfaya yönlendirilir. Ana sayfada, güncel olarak boykot edilen veya edilmeyen şirketler Firestore’dan çekilerek listelenmektedir. Kullanıcı istediği firmayı arayabilir  ya da anasayfadan detay sayfasına gidip detaylıca bakabilir kaynaklarıyla beraber,
isterse  istediği markayı istediği platformadan paylaşabilir. kategoriler sayfasında kategorilere göre firmaları aratabilir, haberler sayfasında boykotla ilgili güncel haberlere bakabilir,hesap sayfasında ise bizimle iletişime gecebilir ya da
marka öner,itiraz edebilir ve en önemli hesabım sayfasından bulamaığı ürünleri chate sorabilir. ve olmayan ürünleride ordan öğrenebilir.
Uygulamanın mimarisi şu şekilde yapılandırılmıştır:

Hilt: Bağımlılık yönetimini sağlamak amacıyla kullanılır. Hilt, DI (Dependency Injection) sağlayarak kodun test edilebilirliğini ve sürdürülebilirliğini artırır.

Clean Architecture: Uygulama, Clean Architecture prensiplerine uygun olarak katmanlara ayrılmıştır. Bu yapı, veri, iş mantığı ve kullanıcı arayüzü bileşenlerinin bağımsız olarak geliştirilmesini sağlar, böylece kodun okunabilirliğini ve sürdürülebilirliğini artırır.

Use Case: İş mantığını yöneten ve işlemleri belirli bir sorumlulukla düzenleyen katmandır. Repository ve ViewModel arasındaki bağlantıyı sağlayarak kodun modülerliğini ve bakımını kolaylaştırır.

ViewModel: Kullanıcı arayüzü ile iş mantığı arasındaki köprüyü kurar ve kullanıcı etkileşimlerine yanıt verir.

View: Sadece kullanıcı arayüzü (UI) kodlarını içerir ve ViewModel’e erişerek UI güncelleme işlemlerini gerçekleştirir.

Repository: Veritabanı veya uzak veri kaynakları ile etkileşimde bulunur. Kullanıcı verilerini ve bilgilendirme içeriğini Firestore’dan sağlar ve Use Case katmanına iletir. Bağımsız olarak test edilebilir ve iş mantığından ayrıdır.

Bu yapı sayesinde uygulamanın kodları daha düzenli, sürdürülebilir ve test edilebilir hale getirilmiştir. Her bir fonksiyon ve sınıf, belirli bir işlevi yerine getirecek şekilde tasarlanmıştır. Bu da uygulamanın bakımı ve geliştirilmesi için büyük avantaj sağlar.


