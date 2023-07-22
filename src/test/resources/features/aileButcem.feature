Feature: Aile

  Background:
    Given kullanıcı driver kurulumlarını yapar
    When ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin
    And "AileButcemMail" ve "AileButcemParola" bilgilerini girerek kullanici bilgileriyle giris yapin
    And uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin

@Test1
  Scenario:Aile butcem hesap bilgilerinin değiştirilebilir olduğu dogrulanır.


    And sol kisimdaki menuden hesabim bolumune gidin
    When hesabim sayfasindaki bilgileri degistirerek degisikleri kaydedin
    And ardindan degisiklerin yapildigini dogrulayin
    And uygulamayı kapatın

@Test2
  Scenario:

    * anasayfadaki arti butonuna tiklayin
    * gelir ekle bolumune tiklayin
    * aciklama,gelir tip, kategori, tarih ve tutari belirleyin ve kaydedin
    * basariyla eklendigini dogrulayin
    * uygulamayı kapatın