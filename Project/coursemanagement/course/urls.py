from django.conf.urls import url 
from course import views 
 
urlpatterns = [ 
    url('course/', views.course_list)
]
